const listaTriggers = document.querySelectorAll('.lista, .trigger')
		listaTriggers.forEach((trigger) => {

			trigger.addEventListener('click', (e) => {
				const lista = trigger.parentElement
				const isOpen = lista.classList.contains('open')

				if (isOpen) {
					lista.classList.remove('open')
				} else {
					lista.classList.add('open')
				}

			})

			
			const mediaQueryList = window.matchMedia("(max-width: 768px)");

			function screenTest(e) {
				if (e.matches) {
					/* the viewport is 768 pixels wide or less */;
					document.getElementById("trigger").style.display = "block";
					lista.classList.remove('open')
				} else {
					/* the viewport is more than 768 pixels wide */
					lista.classList.add('open');
					document.getElementById("trigger").style.display = "none";
				}
			}

			mediaQueryList.addListener(screenTest);
		})


				if (window.matchMedia("(min-width:800px)").matches) {
					lista.classList.add('open');
					document.getElementById("trigger").style.display = "none";
				} else {
					document.getElementById("trigger").style.display = "block";
				}
			
