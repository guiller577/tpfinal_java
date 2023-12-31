const icon = document.getElementById("icon");

const temaOscuro = () => {
  document.body.setAttribute("data-bs-theme", "dark");
  localStorage.theme = "dark";
  icon.setAttribute("class", "bi bi-sun-fill");
};

const temaClaro = () => {
  document.body.setAttribute("data-bs-theme", "light");
  localStorage.theme = "light";
  icon.setAttribute("class", "bi bi-moon-fill text-white");
};

const cambiarTema = () => {
  if (localStorage.theme ? localStorage.theme === "light" : document.body.getAttribute("data-bs-theme") === "light") {
    temaOscuro();
  } else {
    temaClaro();
  }
};

const eliminar = (button) => {
  const respuesta = confirm("¿Está seguro de eliminar el registro?");
  if (respuesta) {
    button.closest("tr").remove();
  }
};

document.addEventListener("DOMContentLoaded", () => {
  const theme = localStorage.theme || document.body.getAttribute("data-bs-theme");
  if (theme === "light") {
    temaClaro();
  } else {
    temaOscuro();
  }
});
