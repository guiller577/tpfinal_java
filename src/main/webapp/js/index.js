const icon = document.getElementById("icon");

const temaOscuro = () => {
  document.body.setAttribute("data-bs-theme", "dark");
  icon.setAttribute("class", "bi bi-sun-fill");
};

const temaClaro = () => {
  document.body.setAttribute("data-bs-theme", "light");
  icon.setAttribute("class", "bi bi-moon-fill");
};

const cambiarTema = () => {
  document.body.getAttribute("data-bs-theme") === "light" ? temaOscuro() : temaClaro();
};

const eliminar = (button) => {
  const respuesta = confirm("¿Está seguro de eliminar el registro?");
  if (respuesta) {
    button.closest("tr").remove();
  }
};
