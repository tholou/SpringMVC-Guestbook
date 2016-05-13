/*
*/

$(document).ready(function() {
	'use strict';

	$('#form').submit(function(e) {

		if(!$('#use_ajax').is(':checked')) {
			return;
		}

		e.preventDefault();

		var form = $(this);

		$.ajax({
			type	: 'POST',
			cache	: false,
			url		: form.attr('action'),
			data	: form.serialize(),
			success	: function(data) {
				$("#entries").append('<div>' + data + '</div>');

				// fix index
				var index = $('#entries div[id^="entry"]').length;
				var textArray = $(data).find('h3').text().split('.', 2);

				$('#entries div[id^="entry"]:last').find('h3').text(index + '.' + textArray[1]);
				$('html, body').animate({scrollTop: form.offset().top}, 2000);

				e.target.reset();
			}
		});
	});
	
	
	
	
	/*$('#form_reply').hide(); //Initially form wil be hidden.

	$('#reply').click(function() {
	 $('#form_reply').show();//Form shows on button click

	 });*/
});

/*
window.onload = function () {
	  document.getElementById('#reply').addEventListener('click', reply)
	  	}*/

//var submit2 = document.getElementsByClassName("reply");

/*if(submit){
	submit.addEventListener("click",reply);
}*/
//for (var i = 0; i < submit2.length; i++) {
//    submit2[i].addEventListener('click', reply(submit2[i].id), false);
//}

//var guest_id1 = document.getElementById("guest_id");
//var guest_id = guest_id1.value;


function reply (id) {
	 console.log(id);
	 var Form = [
	   	      { id: 'name', placeholder: 'Name Field', required: 'required' },
		      { id: 'email', placeholder: 'Email Field', type:'email'},
		      { id: 'comment', placeholder: 'Comment Field', required: 'required' }
		    ]
	  swal.withForm({
	    title: 'GuestBook Reply Form',
	    /*text: 'Any text that you consider useful for the form',*/
	    showCancelButton: true,
	    confirmButtonColor: '#DD6B55',
	    confirmButtonText: 'Submit Reply!',
	    closeOnConfirm: true,
	    formFields: Form
	  }, function (isConfirm) {
	    // do whatever you want with the form data
		  //alert("yesssss");
		  if(isConfirm){
			  
/*			// Setup form validation on the #primaryPostForm element
              $.validate({

                         errorElement: "label", // default is 'label'
                         errorPlacement: function(error, element) {
                         error.insertAfter(element);
                     },

                  // Specify the validation rules
                  rules: [
                          
                	  {'name': this.swalForm.name, 'email': this.swalForm.email, 'comment': this.swalForm.comment }
                  ],

                  // Specify the validation error messages
                  messages: {
                	  this.swalForm.name: '<i class="fa fa-exclamation-circle rediconcolour"></i> ' + " Poor friend!! They have no name!! " + ' <i class="fa fa-exclamation-circle rediconcolour"></i> ',
                	  this.swalForm.email: '<i class="fa fa-exclamation-circle rediconcolour"></i> ' + " Please use a valid Email Format... " + ' <i class="fa fa-exclamation-circle rediconcolour"></i> '
                	  this.swalForm.comment: '<i class="fa fa-exclamation-circle rediconcolour"></i> ' + " Poor friend!! You need to put a comment!! " + ' <i class="fa fa-exclamation-circle rediconcolour"></i> ',
                  }

             }); // end contact-form validate
*/			
			
			//swal.showEmailError()
              //$('#title').css('border-color','red')
			  var isError = false;
              if(this.swalForm.name == "" || this.swalForm.email == "" ||  this.swalForm.comment == ""){
            	//How to display error here ??
            	  alert("An error occured, Kindly fill all form fields correctly!");
            	  var isError = true;
            	  //swal.showInputError('Please enter Name');
                  //this.swalForm.name.showInputError('Please enter Name');
            	  
              }
              
             /* if(this.swalForm.email == ""){
              	//How to display error here ??
            	  alert("Please enter a correct Email format");
            	  var isError = true;
            	  //swal.showInputError('Please enter a correct Email format');
                   // this.swalForm.email.showEmailError('Please enter a correct Email format');
              	  
                }
              */

             /* if(this.swalForm.comment == ""){
            	  alert("Please enter Coment");
            	  var isError = true;
            	//How to display error here ??
            	 // swal.showInputError('Please enter Coment');
                  //this.swalForm.comment.showInputError('Please enter comment');
            	  
              }  */           

             /* if(this.swalForm.title != undefined && this.swalForm.title != "" &&
                  this.swalForm.comment != undefined && this.swalForm.comment != "")*/
              if(isError){
            	  //document.getElementById("clickMe").click();
            	  return false;
              }
              else{
				  $.ajax({
					  headers: {
						 'Accept': 'application/json',
						 'Content-Type': 'application/json'
					  },
						type	: 'POST',
						cache	: false,
						contentType: 'application/json',
						url		: '/guestreply/'+id,
						data	: JSON.stringify({'name': this.swalForm.name, 'email': this.swalForm.email, 'comment': this.swalForm.comment }),
					    dataType: 'json',
						success	: function(data) {
							alert('successful')
						}
					});
              }
		    console.log(this.swalForm) // { name: 'user name', nickname: 'what the user sends' }
		  }
		 
	  })
	}




/*$('#reply').click(function(){
	
	
	  
	});*/

