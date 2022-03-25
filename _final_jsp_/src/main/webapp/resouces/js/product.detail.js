document.getElementById('delBtn').addEventListener('click', () =>{
    const delForm = document.getElementById('delForm');
    delForm.submit();
});
async function postCommentToSever(cmtData){
    try {
        const url = "/cmtCtrl/post";
        const config = {
            method: 'post',
            headers: {
                'Content-Type': 'application/json; charset=utf-8'
            },
            body: JSON.stringify(cmtData)
        };
        const resp = await fetch(url, config);
        const result = await resp.text();
        return result;
    } catch (error) {
        console.log(error);
    }
}
document.getElementById('cmtPostBtn').addEventListener('click',()=>{
    const cmtText = document.getElementById('cmtText').value;
    if(cmtText == null || cmtText == ''){
        alert('댓글 내용을 입력해 주세요!');
        return false;
    }else{
        let cmtData = {
            pno: document.querySelector('#delForm input[name=pno]').value,
            writer: document.getElementById('cmtWriter').innerText,
            content: cmtText
        };
        postCommentToSever(cmtData).then(result => {
            // console.log(result);
            document.getElementById('cmtText').value = '';
            printCommentList(cmtData.pno);
        });
    }
});

async function spreadCommentFromServer(pno){
    try {
        const resp = await fetch('/cmtCtrl/list/'+pno);
        const cmtList = await resp.json();
        return await cmtList;
    } catch (error) {
        console.log(error);
    }
}

function printCommentList(pno){
    spreadCommentFromServer(pno).then(result => {
        console.log(result);

        if(result.length > 0){
            let ul = document.getElementById('cmtListArea');
            ul.innerHTML = '';
            for (let cvo of result) {
                let li = `<li data-cno="${cvo.cno}" class="list-group-item d-flex justify-content-between align-items-start">`;
                li += `<div class="ms-2 me-auto"><div class="fw-bold">${cvo.writer}</div>`;
                li += `${cvo.content}</div>`;
                li += `<span class="badge bg-secondary rounded-pill">${cvo.modAt}</span>&nbsp;`;
                li += `<button type="button" class="btn btn-outline-warning btn-sm py-0 mod" data-bs-toggle="modal" data-bs-target="#myModal">E</button>&nbsp;`;
                li += `<button type="button" class="btn btn-outline-danger btn-sm py-0 del">X</button></li>`;
                ul.innerHTML += li;
            }
        }else{
            console.log('Comment List is empty');
        }
    });
}

async function eraseCommentFromServer(cno){
    try {
        const url = '/cmtCtrl/erase/' + cno;
        const config = {
            method: 'post'
        }
        const resp = await fetch(url, config);
        const result = await resp.text();
        return result;
    } catch (error) {
        console.log(error);
    }
}

document.addEventListener('click',(e)=>{
    if(e.target.classList.contains('del')){
        let li = e.target.closet('li');
        let cno = li.dataset.cno;
        eraseCommentFromServer(cno).then(result=>{
            console.log(result);
            printCommentList(document.querySelector('#delForm input[name=pno]').value);
        });
    }else if(e.target.classList.contains('mod')){
        let li = e.target.closet('li');
        let cno = li.dataset.cno;
        let cmtTextNode = li.querySelector('.fw-bold').nextSibling;
        document.querySelector("#cmtTextMod").value = cmtTextNode.nodeValue;
        document.querySelector("#cmtTextMod").dataset.cno = cno;
    }
});

async function modifyCommentToServer(cmtData){
    try {
        const url = '/cmtCtrl/edit';
        const config = {
            method: 'post',
            header: {
                'Content-Type': 'application/json; charset=utf-8'
            },
            body: JSON.stringify(cmtData)
        };
        const resp = await fetch(url, config);
        const result = await resp.text();
        return result;
    } catch (error) {
        console.log(error);
    }
}

document.getElementById('cmtModBtn').addEventListener('click',()=>{
    let cmtData = {
        cno: document.getElementById('cntTextmod').dataset.cno,
        content = document.getElementById('cmtTextMod').value
    };
    // console.log(cmtData);
    modifyCommentToServer(cmtData).then(result => {
        console.log(result);
        document.querySelector('.btn-close').click();
        printCommentList(document.querySelector('#delForm input[name=pno]').value);
    });
});