const h_pg =document.querySelector('.h-pg')
const s_lk = document.querySelector('.s-lk')
const ln_lk = document.querySelector('.ln-lk')

ln_lk.addEventListener('click',()=>{
    h_pg.classList.add('active');
});
s_lk.addEventListener('click',()=>{
    h_pg.classList.remove('active');
});
