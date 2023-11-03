const  menutoggle = document.querySelector('.menutoggle');
const navlist = document.querySelector('.navlist');
menutoggle.addEventListener('click', function()
{
menutoggle.classList.toggle('active');
navlist.classList.toggle('active');

if(menutoggle.classList.contains('active')){
 menutoggle.innerHTML='<i class="fas fa-bars"></i>'
}
else
{
 menutoggle.innerHTML='<i class="fas fa-times"></i>'
}

}
);