function eliminar(id){
	swal({
  title: "¿Estas seguro de eliminar el registro?",
  text: "Una vez que lo elimines no podras recuperarlo",
  icon: "warning",
  buttons: true,
  dangerMode: true,
})
.then((ok) => {
  if (ok) {
	$.ajax({
		url:"/eliminar/"+id,
		 success: function(res){
			console.log(res);
		}
	});
    swal("Poof! el registr ha sido eliminado!", {
      icon: "success",
    }).then((ok)=>{
		if(ok){
			location.href="/listar"		
		}
	});
  } else {
    swal("El registro esta a salvo!");
  }
});
}