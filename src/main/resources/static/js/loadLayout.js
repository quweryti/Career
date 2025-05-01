/*
 * 
 * version
 * 	   1.0.1
 * date
 *     2025/04/30
 * creater
 *     Nakamura
 * 
 */ 

document.addEventListener("DOMContentLoaded", () => {
	fetch("/layout.html")
		.then(response => {
		if (!response.ok) {
			throw new Error("レイアウト読み込みに失敗しました。"); 
		}	
		return response.text();
		})
		.then(html => {
			document.getElementById("app").innerHTML = html;
		})
		.catch(error => {
			console.error("エラー", error);
		});
});
