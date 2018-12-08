function getCurDate(){
    var d =new Date();
    var week;
    switch(d.getDay()){
        case 1:week="星期一";break;
        case 2:week="星期二";break;
        case 3:week="星期三";break;
        case 4:week="星期四";break;
        case 5:week="星期五";break;
        case 6:week="星期六";break;
        case 7:week="星期日";break;
    }
    var years = d.getFullYear();
    var month = add_zero(d.getMonth()+1);
    var days = add_zero(d.getDate());
    var hours = add_zero(d.getHours());
    var minutes = add_zero(d.getHours());
    var seconds = add_zero(d.getSeconds());
    var ndate = years+"-"+month+"-"+days+" "+hours+":"+minutes+":"+seconds+" "+week;
    var divDate = document.getElementById("divDate");
    var divTime = document.getElementById("divTime");
    var divWeek = document.getElementById("divWeek");
    divDate.innerHTML =years+"-"+month+"-"+days;
    divTime.innerHTML=hours+":"+minutes+":"+seconds
    divWeek.innerHTML=week;
}
function add_zero(temp){
    if(temp<10){
        return "0"+temp;
    }else{
        return temp;
    }
}
setInterval("getCurDate()",100);