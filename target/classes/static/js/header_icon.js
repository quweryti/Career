/*
 * 
 * 	version
 * 	   1.0.1
 * date
 *     2025/04/30
 * creater
 *     中村
 * 
 */ 


fetch('/header.html')
	.then(res => res.text())
	.then(data => {
		document.getElementById('header-container').innerHTML = data;
	});