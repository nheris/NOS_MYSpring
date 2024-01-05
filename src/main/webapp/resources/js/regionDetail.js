/**
 * 
 */
 
 const del = document.getElementById("del");
 const frm = document.getElementById("frm");
 const up =  document.getElementById("up");

 up.addEventListener("click", function(){
    // js에서 EL $못씀 값가져오기 data-  
    let id = console(up.getAttribute('data-rigion-id'));

    location.href="./updeate?region_id="+id;
 })

 del.addEventListener("click",()=>{
    let result = confirm("정말 지울거임?");

    if(result){
        frm.onsubmit();
    }
 });
 
 