//标题栏选中状态控制数据行
function allSelect1() {
    let dom = document.getElementById("one");
    let flag = dom.checked;
    let domList = document.getElementsByName("ck");
    for (let i = 0; i < domList.length; i++) {
        domList[i].checked = flag;
    }
}

//数据行选中状态控制标题行
function allSelect2() {
    let domList = document.getElementsByName("ck");
    let dom = document.getElementById("one");
    let count = 0;
    for (let i = 0; i < domList.length; i++) {
        if (domList[i].checked === true) {
            count++;
        }
    }
    dom.checked = count === domList.length;
}

//鼠标悬停数据变色
function overColor() {
    this.style.backgroundColor = "yellow";
}

//鼠标移开变色
function outColor() {
    this.style.backgroundColor = "white";
}

function init() {
    document.getElementById("one").onclick = allSelect1;

    let domList = document.getElementsByName("ck");
    for (let i = 0; i < domList.length; i++) {
        domList[i].onclick = allSelect2;
    }

    let trList = document.getElementsByTagName("tr");

    for (let i = 1; i < trList.length; i++) {
        trList[i].onmouseover = overColor;
        trList[i].onmouseout = outColor;
    }
}

window.onload = init;