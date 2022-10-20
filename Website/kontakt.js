/* When the user clicks on the button, 
toggle between hiding and showing the dropdown content */
function myFunction() {
	document.getElementById("myDropdown").classList.toggle("show");
}

// Close the dropdown if the user clicks outside of it
window.onclick = function (e) {
	if (!e.target.matches(".nav-bar")) {
		var myDropdown = document.getElementById("myDropdown");
		if (myDropdown.classList.contains("show")) {
			myDropdown.classList.remove("show");
		}
	}
};

/* Kontakt Seite */

const portfolioItems = document.querySelectorAll(".portfolio-item-wrapper");

portfolioItems.forEach((portfolioItem) => {
	portfolioItem.addEventListener("mouseover", () => {
		portfolioItem.childNodes[1].classList.add("img-darken");
	});

	portfolioItem.addEventListener("mouseout", () => {
		portfolioItem.childNodes[1].classList.remove("img-darken");
	});
});

let title = document.querySelector(".das-bin-ich-title");
let text = document.querySelector(".text");

window.onscroll = () => {
	let pos = window.scrollY;
	title.style.top = `${pos}px`;
	text.style.top = `${pos}px`;
};
