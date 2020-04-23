
// Function that checks if required fields are empty (or not).
function validateForm()
{
  var x = document.forms["formCheck"]["Forename"];
  var y = document.forms["formCheck"]["Surname"];
  var z = document.forms["formCheck"]["Email"];
  var k = document.forms["formCheck"]["Message"];
  var b = document.forms["formCheck"]["Amount"];

  if (x.value == "" || y.value == "" || z.value == "" || k.value == "" || b.value == "")
  {

    alert("A feild(s) is empty!");

    // for x
    if (x.value == "") {
      x.style.border = "solid 2px #EA593C";
      x.style.transition = "ease 0.6s";
    }
    else { x.style.border = ""; x.style.transition = "ease 0.6s"; }

    // for y
    if (y.value == "") {
      y.style.border = "solid 2px #EA593C";
      y.style.transition = "ease 0.6s";
    }
    else { y.style.border = ""; y.style.transition = "ease 0.6s"; }

    //for z
    if (z.value == "") {
      z.style.border = "solid 2px #EA593C";
      z.style.transition = "ease 0.6s";
    }
    else { z.style.border = ""; z.style.transition = "ease 0.6s"; }

    // for k
    if (k.value == "") {
      k.style.border = "solid 2px #EA593C";
      k.style.transition = "ease 0.6s";
    }
    else { k.style.border = ""; k.style.transition = "ease 0.6s"; }

    // for b
    if (b.value == "") {
      b.style.border = "solid 2px #EA593C";
      b.style.transition = "ease 0.6s";
    }
    else { b.style.border = ""; b.style.transition = "ease 0.6s"; }

    return false;
  }
}
