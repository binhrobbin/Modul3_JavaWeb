var index = 1;
function changeImage(){
    var imgs = ["static/data/background/dogBG2.jpg", "static/data/background/dogBG3.jpg", "static/data/background/dogBG1.jpg"];
    document.getElementById('backgroundimgID').src = imgs[index];
    index++;
    if(index==3){
        index=0;
    }
}
// setInterval(changeImage() ,1000);