object RandomFailure {
  def main(args: Array[String]): Unit = {
    if (Math.random() < 0.1) sys.error("failed")
  }
}
