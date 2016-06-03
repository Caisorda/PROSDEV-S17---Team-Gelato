$(window).scroll(function(){

  var wScroll = $(this).scrollTop();

    waffleScroll();
    
    $('.icecream').css({
      'transform' : 'translate(0px, '+ wScroll /10 +'%)'
    })  
    $('.logo').css({
      'transform' : 'translate(0px, '+ wScroll /20 +'%)'
    });
      
    $('.rectangle-1').css({
      'transform' : 'translate(0px, -'+ wScroll /30 +'%)'
    });
    
    
    if(wScroll == $('.about').offset().top){

    console.log("hi");
  }
});

$('.description').hover(function(){
    $('.desc-overlay').fadeIn();
});

function waffleScroll(){
    var wScroll = $(this).scrollTop();
    $('.circle-1').css('background-position', wScroll +'px -' + wScroll + 'px');

}

$(function() {
  $('a[href*="#"]:not([href="#"])').click(function() {
    if (location.pathname.replace(/^\//,'') == this.pathname.replace(/^\//,'') && location.hostname == this.hostname) {
      var target = $(this.hash);
      target = target.length ? target : $('[name=' + this.hash.slice(1) +']');
      if (target.length) {
        $('html, body').animate({
          scrollTop: target.offset().top
        }, 1000);
        return false;
      }
    }
  });
});