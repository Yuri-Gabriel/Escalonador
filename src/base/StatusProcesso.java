package base;

enum StatusProcesso {
	INICIANDO(0),
	EXECUTANDO(1),
	BLOQUEADO(2),
	PRONTO(3),
	FINALIZADO(4);

	StatusProcesso(int i) { }
}
