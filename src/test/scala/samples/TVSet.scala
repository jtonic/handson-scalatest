package samples

/**
 * Created by jtonic on 27.08.2014.
 */
class TVSet {
  private var on: Boolean = false
  def isOn: Boolean = on
  def pressPowerButton() = {
    on  = !on
  }
}
