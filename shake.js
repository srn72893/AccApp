//TODO : 現状傾けただけでもカウントが進む。センサー値のノイズ除去必要

let shakeCount = 0;
let lastShake = 0;
const SHAKE_THRESHOLD = 1000000; //このベクトルの大きさを超えた時 1 カウントとする
const COOLDOWN = 20;       //500ms 間隔で 1 回カウント

//id="shake" ボタン要素取得
const shakeBtn = document.getElementById('shake');
//押されたら
shakeBtn.addEventListener('click', async () => {
    if (DeviceOrientationEvent.requestPermission) {
        //アクセス許可されるまで待つ
        const res = await DeviceOrientationEvent.requestPermission();

        if (res === "granted") {
            window.addEventListener("deviceorientation", event => {
                console.log(event.alpha, event.beta, event.gamma);
            })
        }
    }

    window.addEventListener("deviceorientation", (event) => {
        handleMotion(event);

        shakeBtn.disabled = true;
        shakeBtn.innerText = '計測中...';
    })

});

function handleMotion(event) {
    const gyro = event.rotationRate;
    if (!gyro) return;

    const a = gyro.alpha || 0;
    const b = gyro.beta || 0;
    const g = gyro.gamma || 0;
    //3 方向ベクトルを合成
    const totalRotation = Math.sqrt(a*a + b*b + c*c);
    const now = Date.now();

    //ベクトル値が閾値を超えた && 前回の値取得から 500ms の時間経った
    if (totalRotation > SHAKE_THRESHOLD && (now - lastShake) > COOLDOWN) {
        shakeCount++;
        lastShake = now;
        document.getElementById('count').innerText = shakeCount;
    }
}
