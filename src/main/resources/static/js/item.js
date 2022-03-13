let index ={
    init:function (){
        $("#btn-save").on("click", () =>{
            this.save();
        });
},

 save : function (){
        let data= {
            name: $("#name").val(),
            price: $("#price").val()
        };

        $.ajax({
            type: "POST",
            url: "/item",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        }).done(function (resp){
            alert("아이템 저장완료");
            location.href = "/";
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
 }
}
index.init();
