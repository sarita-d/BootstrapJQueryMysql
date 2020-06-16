$(document).ready(function(){
	/*alert("sa");*/
});

$("#buscar").click(function(event){
	var x = $("#cajita").val();
	$.post('uc',{
		nombre:x,
		op:'2'
	},function(data, status){
		$("#datos").html(data);
	});
});
$("#login").click(function(event){
	var a = $("#user").val();
	var b = $("#pass").val();
	$.post('lc',{
		user:a,
		pass:b	
	},function(data, status){
		if(data==1){
			
			window.location.href = "../../../pw001/panel.html"
		}else{
			alert("Usuario o password incorrecto..!")
		}
	});
});

$("#signuot").click(function(event){
	alert("Estas seguro de salir del sistema?")
	window.location.href = "../../../pw001/index.html"
});
$("#suot").click(function(event){
	alert("Estas seguro de salir del sistema?")
	window.location.href = "../../../pw001/index.html"
});