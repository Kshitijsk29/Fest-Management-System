const list=document.querySelector('.list')
const btn=document.querySelector('.b1')
const b1=document.querySelector('.b1')
const b2=document.querySelector('.b2')
const b01 = document.querySelector('.b01')
const b02= document.querySelector('.b02')

b01.addEventListener('click',()=>{
    list.classList.add('active');
});
b01.addEventListener('click',()=>{
    btn.classList.add('active');
});
b1.addEventListener('click',()=>{
    b2.classList.add('active');
});
b2.addEventListener('click',()=>{
    b2.classList.remove('active');
});
b02.addEventListener('click',()=>{
    list.classList.remove('active');
});
b02.addEventListener('click',()=>{
    btn.classList.remove('active');
});