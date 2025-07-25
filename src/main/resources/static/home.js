let apicultor = JSON.parse(localStorage.getItem("apicultor"));

if (!apicultor) {
    window.location.href = "login.html";
} else {
    fetch(`/apicultor/atulizar-dados?nome=${encodeURIComponent(apicultor.nome)}`)
        .then(res => {
            if (!res.ok) throw new Error("Erro ao atualizar dados");
            return res.json();
        })
        .then(apicultorAtualizado => {
            apicultor = apicultorAtualizado;

            localStorage.setItem("apicultor", JSON.stringify(apicultorAtualizado));

            document.getElementById("nome").textContent = apicultor.nome;
            document.getElementById("nomeCard").textContent = apicultor.nome;
            document.getElementById("email").textContent = apicultor.email;
            document.getElementById("colmeias").textContent = apicultor.quantidadeColmeias;
            document.getElementById("mel").textContent = apicultor.quantidadeMel_kg;
            document.getElementById("valorReceber").textContent = apicultor.valorReceber ? apicultor.valorReceber.toFixed(2) : "0.00";
            document.getElementById("pago").textContent = apicultor.pago ? "Não" : "Sim";
        })
        .catch(err => {
            console.error(err);
            alert("Erro ao carregar dados atualizados, mostrando dados locais.");

            document.getElementById("nome").textContent = apicultor.nome;
            document.getElementById("nomeCard").textContent = apicultor.nome;
            document.getElementById("email").textContent = apicultor.email;
            document.getElementById("colmeias").textContent = apicultor.quantidadeColmeias;
            document.getElementById("mel").textContent = apicultor.quantidadeMel_kg;
            document.getElementById("valorReceber").textContent = apicultor.valorReceber ? apicultor.valorReceber.toFixed(2) : "0.00";
            document.getElementById("pago").textContent = apicultor.pago ? "Não" : "Sim";
        });
}

function calcularServicos() {
    if (!apicultor) {
        alert("Apicultor não definido.");
        return;
    }

    let servicos = "0";
    document.querySelectorAll("input[type=checkbox]:checked").forEach(cb => {
        servicos += cb.value;
    });

    fetch(`/apicultor/servicos?nome=${encodeURIComponent(apicultor.nome)}&servicos=${servicos}`)
        .then(res => {
            if (!res.ok) throw new Error("Erro ao calcular");
            return res.json();
        })
        .then(data => {
            document.getElementById("valorReceber").textContent = data.valor.toFixed(2);
            document.getElementById("resultado").innerText = `🍯 Valor a pagar pelos serviços: R$ ${data.valor.toFixed(2)}`;

            return fetch(`/apicultor/atulizar-dados?nome=${encodeURIComponent(apicultor.nome)}`);
        })
        .then(res => {
            if (!res.ok) throw new Error("Erro ao atualizar dados após cálculo");
            return res.json();
        })
        .then(apicultorAtualizado => {

            apicultor = apicultorAtualizado;
            localStorage.setItem("apicultor", JSON.stringify(apicultorAtualizado));

            document.getElementById("nome").textContent = apicultor.nome;
            document.getElementById("nomeCard").textContent = apicultor.nome;
            document.getElementById("email").textContent = apicultor.email;
            document.getElementById("colmeias").textContent = apicultor.quantidadeColmeias;
            document.getElementById("mel").textContent = apicultor.quantidadeMel_kg;
            document.getElementById("valorReceber").textContent = apicultor.valorReceber ? apicultor.valorReceber.toFixed(2) : "0.00";
            document.getElementById("pago").textContent = apicultor.pago ? "Não" : "Sim";
        })
        .catch(err => {
            document.getElementById("resultado").innerText = `❌ ${err.message}`;
            console.error(err);
        });
}

