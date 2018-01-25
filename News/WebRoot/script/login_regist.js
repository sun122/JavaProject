

$('a.rigist').click(function(){
    $('div.rigest').css({display:"block"});
    $('div.jumu').css({display:"block"});
});
$('a.login').click(function(e){
    e.preventDefault();
    $('div.login').css({display:"block"});
    $('div.jumu').css({display:"block"});
});


$('span.close').click(function(e){
    e.preventDefault();
    e.stopPropagation()
    close();
});

function close(){
    $('div.login').css({display:"none"});
    $('div.jumu').css({display:"none"});
    $('div.rigest').css({display:"none"});
}

function shake(o){
    var $panel = $(o);
    box_left = ($(window).width() -  $panel.width()) / 2;
    $panel.css({'left': box_left,'position':'absolute'});
    for(var i=1; 4>=i; i++){
        $panel.animate({left:box_left-(40-10*i)},50);
        $panel.animate({left:box_left+2*(40-10*i)},50);
    }
}


$('form').click(function(){
    //e.preventDefault();
    $('span.ts').text(" ");
});

var str0 = $('div.rigest form input').eq(0);//ע���û���
var str2 = $('div.rigest form input').eq(2);//����
var email ="";
function bluf(name,value){
    $.post('CheckN_Servlet',{name:value},function(data){
        if(data.length>0){
            email = data[0].email;
        }
        var z=0;
        for(var i in data){
            z++;
        }
        if(z>0){
            $('span.titleu').text("用户名已存在");
        }
    },"JSON");
}
str0.blur(function(){//�û���
    bluf(name,$(this).val());
});
str2.blur(function(){
    if(str2.val().trim()==email.trim()){
        $('span.titleu1').text("邮箱不能为空");
    }
});

function lose(){
    $('span.titleu').text("");

}
str0.change(function(){
    lose();
});
str2.change(function(){
    $('span.titleu1').text("");
});
var name='';//用户名称
$('form').submit(function(e){
    e.preventDefault();

    var divr = $('div.rigest');
    var dirl = $('div.login');

    var classname = $(this).parent().attr('class');
    switch(classname){

        case  'rigest':
            var str1 = $('div.rigest form input').eq(1).val().trim();//����
            var str2 = $('div.rigest form input').eq(2).val().trim();//����
            var str3 = $('div.rigest form input').eq(3).val().trim();//�û�����
            /*         			$.ajax({
             url:'TestServlet',
             data:{username:str0.val(),password:str1,email:str2,userclass:str3},
             type:'post',
             dataType:'JSON',
             success:function(data){
             console.log(data+"����"+data.length);
             console.log(data[0]+" "+ data[1]);

             if(data.length>0){
             close();
             }
             },
             error:function(e){
             alert(e);
             }
             }); */

            $.post('RegU_Servlet',{username:str0.val(),password:str1,email:str2,userclass:str3},function(data){
                if(data.length>0){
                    close();
                }
            },"json");
            break;
        //登录
           
        case 'login':
            var strl0 = $('div.login form input').eq(0).val().trim();//用户名
            var strl1 = $('div.login form input').eq(1).val().trim();//密码
            var strl2 = $('div.login form input').eq(2).val().trim();;//确认密码
   
            if(strl1 == strl2){
                $.ajax({
                    url:'ptuserlogin',
                    data:{username:strl0,password:strl1},
                    type:'post',
                    dataType:'JSON',//服务器返回数据类型。
                    success:function(data){
                        $('a.login').css({display:"none"});
                        $('a.rigist').css({display:"none"});

                        sessionStorage.setItem('username',data.name);
                       // name = sessionStorage.getItem('username');
                        $('a.welcome').text("欢迎你！"+data.name);
                       // $('a.welcome').css({display:"block"});
                        close();
                    },
                    error:function(e){
                        alert(e);
                    }
                });
            }else{
                shake($(this).parent());
                $('span.ts').text("两次密码不一致");
            }
            break;
    }
});

name = sessionStorage.getItem('username');

if(name>0){
	console.log("name>0");
	$('a.welcome').text("欢迎你！"+name);
}else{
	//$('a.welcome').css({display:"none"});
}