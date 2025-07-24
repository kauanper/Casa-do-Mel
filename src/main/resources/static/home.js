const apicultor = JSON.parse(localStorage.getItem("apicultor"));

if (!apicultor) {
    window.location.href = "login.html";
}

document.getElementById("nome").textContent = apicultor.nome;
document.getElementById("email").textContent = apicultor.email;
document.getElementById("senha").textContent = apicultor.senha;
document.getElementById("colmeias").textContent = apicultor.quantidadeColmeias;
document.getElementById("mel").textContent = apicultor.quantidadeMel_kg;
document.getElementById("valorReceber").textContent = apicultor.valorReceber.toFixed(2);
document.getElementById("pago").textContent = apicultor.pago ? "Sim" : "Não";

function calcularServicos() {
    let servicos = "0";
    document.querySelectorAll("input[type=checkbox]:checked").forEach(cb => {
        servicos += cb.value;
    });

    fetch(`/apicultor/servicos?nome=${apicultor.nome}&servicos=${servicos}`)
        .then(res => {
            if (!res.ok) throw new Error("Erro ao calcular");
            return res.json();
        })
        .then(data => {
            document.getElementById("resultado").innerText = `🐝 Valor a receber pelos serviços: R$ ${data.valor.toFixed(2)}`;
        })
        .catch(err => {
            document.getElementById("resultado").innerText = err.message;
        });
}
