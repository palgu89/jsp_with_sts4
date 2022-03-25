let resignBtn = document.getElementById('resignBtn');
resignBtn.addEventListener('click', (e)=>{
    e.preventDefault();
    let modForm = document.getElementById('modForm');
    modForm.setAttribute('action', '/memCtrl/remove');
    modForm.submit();
});