let menu=document.querySelector('#menu-icon');
let navbar=document.querySelector('.navbar');

menu.onclick =()=>{
    menu.classList.toggle('bx-x');
    navbar.classList.toggle('active');
}
window.onscroll =()=>{
    menu.classList.remove('bx-x');
    navbar.classList.remove('active');
}
const sr=ScrollReveal({
    distance:'60px',
    duration:2500,
    delay:200,
    reset:true
})
sr.reveal('.text',{delay:100, origin:'top'})
sr.reveal('.form-container form',{delay:400, origin:'left'})
sr.reveal('.heading',{delay:400, origin:'top'})
sr.reveal('.ride-container .box',{delay:300, origin:'top'})
sr.reveal('.services-container .box',{delay:300, origin:'top'})
sr.reveal('.about-container .box',{delay:300, origin:'top'})
sr.reveal('.reviews-container ',{delay:300, origin:'top'})
sr.reveal('.newsletter .box',{delay:200, origin:'bottom'})

// Get the modal
var modal = document.getElementById('id01');

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
}
function myFunction() {
  var x = document.getElementById("snackbar");
  x.className = "show";
  setTimeout(function(){ x.className = x.className.replace("show", ""); }, 3000);
}

