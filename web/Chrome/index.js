window.onload=function () {
    console.log(window.location);
    var favicon = window.location.protocol+"//"+window.location.host + "/favicon.ico";   //网站小图标
    let host=window.location.host; //网站host，用于popup.html中  <p class="circle-source">host</p>
    let href=window.location.href;//网站网址，传到其他的页面的网址
    let title=document.title;  //网站标题，传到其他的页面的标题中





    $(document).click(function (e) {
        console.log(e.target);

    });
};