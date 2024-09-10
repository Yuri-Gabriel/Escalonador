package base;

public enum StatusProcesso {
  INICIANDO(0),
  PRONTO(1),
  EXECUTANDO(2),
  BLOQUEADO(3),
  FINALIZADO(4);

  StatusProcesso(int i) { }
}
