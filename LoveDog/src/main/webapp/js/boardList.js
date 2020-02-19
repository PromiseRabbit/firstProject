// 페이지 줄 갯수
function pageList(){
	var index = document.getElementById("index");
	var pageNum = document.getElementById("pageNum");
	var listNum = document.getElementById("listNum");
	
	index.value=0;
	pageNum.value=1;
	listNum.value= document.getElementById("list").value; 
	
	alert(index.value+":"+pageNum.value+":"+listNum.value);
	

}

// 첫번째 페이지 
function pageFirst(){
	
	var index = document.getElementById("index");
	var pageNum = document.getElementById("pageNum");
	index.value = 0
	pageNum.value = 1;

	
}


// 이전 페이지
function pagePre(num, pageList){
//	alert(num +":"+ pageList);
	if(0<num-pageList){
		num -= pageList;
	var index = document.getElementById("index");
	var pageNum = document.getElementById("pageNum");
	
	pageNum.value = num;
	index.value = num-1;
	}
	
}

function pageNext(num, total, listNum, pageList){
	var index = Math.ceil(total/listNum); // 30/5 6
	var max = Math.ceil(index/pageList); //  6/5
	
	if(max*pageList > num+pageList){
		num += pageList;
		
		var index = document.getElementById("index");
		var pageNum = document.getElementById("pageNum");
		
		pageNum.value = num;
		index.value = num-1;
	}
	
}



function pageLast(num, total, listNum, pageList){
	
	var idx =  Math.ceil(total/listNum);
	var max = Math.ceil(idx/pageList);
	
	while(max*pageList > num+pageList){
		num += pageList;
	}
	
	var index = document.getElementById("index");
	var pageNum = document.getElementById("pageNum");
	
	pageNum.value = num;
	index.value = idx-1;
	
	
}

function pageIndex(pageNum){
	var index = document.getElementById("index");
	index.value = pageNum -1;
	
}



