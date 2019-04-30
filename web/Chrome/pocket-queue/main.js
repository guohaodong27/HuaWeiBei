$(document).ready(function () {
    $(".hidden-nav").hide();
        $(".user").click(function () {
            $(".hidden-nav").fadeToggle("fast","linear");

        });
    $(".buttons").hide();
        $(".main-userpage").mouseover(function () {
        $(this).children(".userpage-source").children("ul").fadeIn("slow");
        $(this).children(".userpage-source").children("ul").stop(true,true);

    });
    $(".main-userpage").mouseout(function () {
        $(this).children(".userpage-source").children("ul").fadeOut("slow");
        $(this).children(".userpage-source").children("ul").stop(true,true);
    });
});