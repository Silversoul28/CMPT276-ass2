function processKey(evt){
    console.log(evt.key)
   }

 window.addEventListener("keypress", processKey)


 let operate =function(evt){

    evt.preventDefault()
    let A=document.querySelector('#num1').value //# is for id
    
    let B=document.querySelector('#num2').value
    var op= document.querySelector('#op').selectedIndex
    let C=0
    if(op==0){
    C =parseInt(A)+parseInt(B)
    }
    else if(op==1){
    C =parseInt(A)-parseInt(B)
    }
    else if(op==2){
    C =parseInt(A)*parseInt(B)
    }
    else{
//error

    }

    // document.getElementById('result').value=C
    document.querySelector('#result').value=C
    console.log(C)
    
    }
    
   // operate()  //callback 
    
    var num1=document.querySelector('#num1').value //# is for id
    
    var num2=document.querySelector('#num2').value
    
    document.querySelector('#form2').addEventListener('submit', operate)


