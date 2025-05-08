/**
 * File:    header_icon.js
 * Purpose: ヘッダーアイコンを挿入するJS
 *
 * @since   2025/05/08
 * @version 1.0.0
 * @author  中村
 */

fetch('/header.html')
	.then(res => res.text())
	.then(data => {
		document.getElementById('header-container').innerHTML = data;
	});
