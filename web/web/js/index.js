function mdel(t_id){
    if(confirm('是否确认删除')){
        window.location.href='member.del?t_id='+t_id;
    }
}
function edel(e_id){
    if(confirm('是否确认删除')){
        window.location.href='equipment.del?e_id='+e_id;
    }
}
function mydel(m_id){
    if(confirm('是否确认删除')){
        window.location.href='money.del?m_id='+m_id;
    }
}
function rdel(r_rid){
    if(confirm('是否确认删除')){
        window.location.href='record.del?r_rid='+r_rid;
    }
}
function mpage(pageNo){
    window.location.href="member?pageNo="+pageNo;
}
function epage(pageNo){
    window.location.href="equipment?pageNo="+pageNo;
}
function mypage(pageNo){
    window.location.href="money?pageNo="+pageNo;
}
function rpage(pageNo){
    window.location.href="record?pageNo="+pageNo;
}
function backindex(){
    window.location.href="index.html";
}
