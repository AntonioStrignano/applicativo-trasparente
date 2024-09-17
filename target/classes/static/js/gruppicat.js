document.addEventListener("DOMContentLoaded", function() {
	const buttons = document.querySelectorAll(".modificaButton");

	buttons.forEach(button => {
		button.addEventListener("click", function() {
			const id = this.id.replace("modificaButton", "");
			const form = document.getElementById(`myForm${id}`);

			if (form.style.visibility === "hidden") {
				form.style.visibility = "visible";
				form.style.height = "auto";
			} else {
				form.style.visibility = "hidden";
				form.style.height = 0;
			}
		});
	});
});
