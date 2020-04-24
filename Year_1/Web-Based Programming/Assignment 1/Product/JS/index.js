
// Jquery function that changes transparency of nav bar when user scrolls.
$(document).ready(function() {
  var width = 0;
  var scroll_pos = 0;
  $(window).scroll(function() {
    width = $(this).width();
    scroll_pos = $(this).scrollTop();
    if (scroll_pos >= 1) {
      $('#menu').css({'background-color':'rgba(157, 186, 176, 1)', 'transition':'ease 0.6s'});
    } else if (width <= 672) {
      $('#menu').css({'background-color':'rgba(157, 186, 176, 1)', 'transition':'ease 0.6s'});
    }
    else {
      $('#menu').css({'background-color':'rgba(157, 186, 176, 0.8)', 'transition':'ease 0.6s'});
    }
    console.log(scroll_pos);
  });
});

// Simple function to activate hamburger menu.
function hamCross(z)
{
        if (z.classList.toggle("change") == true)
        { document.body.classList.add('menuView'); }
        else { document.body.classList.remove('menuView'); }
}
