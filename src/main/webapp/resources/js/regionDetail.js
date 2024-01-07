/**
 * 
 */
 
 const del = document.getElementById("del");
 const frm = document.getElementById("frm");
 const up =  document.getElementById("up");

 up.addEventListener("click", function(){
    // js에서 EL $못씀 값가져오기 data- **사용
    // 개발자가 element의 속성값으로 data를 넣고 싶을 때 사용
    // 사용자 정의 속성
    // data-속성명

    frm.setAttribute("action", "update");
    frm.setAttribute("method", "get");
    frm.submit();
    //let id=up.getAttribute('data-region-id');
    //location.href="./update?region_id="+id;
 })

 del.addEventListener("click", function(){
   let result = confirm("정말 지우지겠습니까?");  

   if(result){
     frm.submit();  
   }
});
 
 