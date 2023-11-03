/Email/ 
function validation()
{
	var form=document.getElementById("Form");
	const email=document.getElementById("email").value;
	const text=document.getElementById("text");
	const pattern=/^[^]+@[^]+\.[a-z]{2,3}$/;
	if(email.match(pattern))
	{
		form.classList.add("valid");
		form.classList.remove("invalid");
		text.innerHTML="Your Email Address is Valid";
		text.style.color="#0000FF";
       
	}
	else
	{
		form.classList.remove("valid");
		form.classList.add("invalid");
		text.innerHTML="*Please Enter Valid Email Address";
		text.style.color="#ff0000";
    
	}
      
}
// 
function msg(data)
{
    var form=document.getElementById("Form");
    const password=document.getElementById("password").value;
    const error=document.getElementById("error");
    const len=new RegExp('(=?.{6,})');
    if(len.test(data))
    {
        form.classList.add("valid");
		form.classList.remove("invalid");
		error.innerHTML="Your Password is Valid";
		error.style.color="#0000FF";
    }
    else
    {
        form.classList.remove("valid");
		form.classList.add("invalid");
		error.innerHTML="*minimum 6 char long";
		error.style.color="#ff0000";
    }
}


