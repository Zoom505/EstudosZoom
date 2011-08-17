import java.util.Arrays;

import javax.swing.JOptionPane;

public class Exercicios {
	public static void main(String[] args) {

		int pagamento = 0;

		pagamento = Integer.parseInt(JOptionPane.showInputDialog(null,
				"Digite o valor do pagamento (M�x. 50.000)"));

		if (pagamento > 0 && pagamento < 50001) {

			int numeroDeMoedas = 0;
			numeroDeMoedas = Integer.parseInt(JOptionPane.showInputDialog(null,
					"Digite a quantidade de moedas existentes em seu Pa�s "
							+ "(M�x. 100 moedas diferentes"));

			if (numeroDeMoedas > 0 && numeroDeMoedas < 101) {

				int arrayDasMoedas[] = new int[numeroDeMoedas];

				String valorDasMoedas = JOptionPane.showInputDialog(null,
						"Digite o valor das moedas separados"
								+ " por v�rgula (e sem espa�o)");

				String tar = valorDasMoedas;
				String valorIndividualMoeda[] = tar.split("\\,");

				int contagemDeNumeroDeMoedas = 0;

				contagemDeNumeroDeMoedas = valorDasMoedas.split("\\,").length;

				if (contagemDeNumeroDeMoedas == numeroDeMoedas) {

					int numeroDentroDoArray = 0;
					while (numeroDentroDoArray < numeroDeMoedas) {

						arrayDasMoedas[numeroDentroDoArray] = Integer
								.parseInt(valorIndividualMoeda[numeroDentroDoArray]);

						numeroDentroDoArray = numeroDentroDoArray + 1;
					}

					Arrays.sort(arrayDasMoedas);

					int moedasUtilizadas[] = new int[numeroDeMoedas];
					numeroDentroDoArray = numeroDeMoedas;

					while (numeroDentroDoArray > 0) {

						numeroDentroDoArray = numeroDentroDoArray - 1;
						moedasUtilizadas[numeroDentroDoArray] = pagamento
								/ arrayDasMoedas[numeroDentroDoArray];
						pagamento = pagamento
								% arrayDasMoedas[numeroDentroDoArray];

					}

					if (pagamento % arrayDasMoedas[numeroDentroDoArray] == 0) {

						numeroDentroDoArray = numeroDeMoedas;
						while (numeroDentroDoArray > 0) {
							numeroDentroDoArray = numeroDentroDoArray - 1;
							if (moedasUtilizadas[numeroDentroDoArray] != 0) {

								System.out.println("Voc� precisar� de "

								+ moedasUtilizadas[numeroDentroDoArray]
										+ " moedas de "
										+ arrayDasMoedas[numeroDentroDoArray]
										+ " $");
							}

						}
						numeroDentroDoArray = numeroDeMoedas;
						int resultadoFinal = 0;
						while (numeroDentroDoArray > 0) {
							numeroDentroDoArray = numeroDentroDoArray - 1;
							resultadoFinal = resultadoFinal
									+ moedasUtilizadas[numeroDentroDoArray];

						}

						System.out.println("Num total M�NIMO de "
								+ resultadoFinal + " moedas.");

					} else {
						System.out
								.println("� imposs�vel pagar sem sobrar troco!");

					}

				} else {

					JOptionPane
							.showMessageDialog(
									null,
									"O n�mero de valores digitados para cada moeda "
											+ "n�o bate com o n�mero de moedas informado!");

				}

			} else {

				JOptionPane.showMessageDialog(null,
						"N�mero de moedas n�o suportado!");

			}

		} else {

			JOptionPane.showMessageDialog(null,
					"Valor de compra n�o suportado!");

		}

	}
} 

