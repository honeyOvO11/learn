// 交互1：首页弹窗
function showMsg() {
    alert('欢迎来到千早爱音的个人站！\n今天也要加油学习前端哦！');
}

// 交互2：作品1 - 切换显示详情
function toggleDetail(id) {
    var el = document.getElementById(id);
    if (el.style.display === 'none') {
        el.style.display = 'block';
    } else {
        el.style.display = 'none';
    }
}

// 交互3：作品3 - 弹出详情弹窗（和切换不一样）
function showDetailPopup() {
    alert('📌 作品3 - JS交互练习\n\n' +
          '这个作品学习了DOM操作和事件绑定。\n' +
          '实现了点击弹窗和切换显示内容两个交互功能。\n\n' +
          '✨ 继续加油，未来做更复杂的交互！');
}

// 交互4：关于页联系弹窗
function contact() {
    alert('📧 邮箱：anon@MyGo.com\n💬 欢迎一起交流学习！');
}