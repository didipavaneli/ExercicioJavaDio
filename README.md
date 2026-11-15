# 📚 Exercício – Conta Bancária em Java

Este repositório contém a solução do exercício **“Conta Bancária”**, que implementa uma classe capaz de:

- 📈 Consultar saldo
- 💳 Consultar limite de cheque especial
- ➕ Depositar dinheiro
- ➖ Sacar dinheiro
- 🧾 Pagar um boleto
- ❓ Verificar se a conta está usando cheque especial

---

## 📋 Regras de negócio

| Regra | Descrição |
|------|-----------|
| **Limite de cheque especial** | É somado ao saldo da conta. |
| **Definição do limite na criação** | • Depósito inicial **≤ R$ 500,00** → Cheque especial **R$ 50,00**.<br>• Depósito inicial **> R$ 500,00** → Cheque especial **50 % do valor depositado**. |
| **Taxa de uso do cheque especial** | Quando o cheque especial é utilizado, ao repor o saldo a conta cobra **20 %** do valor efetivamente usado do cheque especial. A taxa incide apenas sobre a parte consumida. |

---


