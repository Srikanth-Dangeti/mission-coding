package googleInterviewQuestion;

/***
 * You are designing a JSON webpage viewer with the ability for users to save and load previously viewed JSON documents.
 * The webpage sends/receives the complete state of the world from webpage to the backend server on each update/save.
 * The state of the world is stored in simpleJSON. The client has the original document D1 and the modified Documnet D2,
 * where D2 is D1 + Delta.
 * You began profiting the application and notice that for very large JSON document being saved its very slow - even if
 * no change has been produced.
 * Optimise the space-efficiently of saving the changes for a given SimpleJSON document where you are given 'old_doc'
 * and 'new_old' .
 *
 *  SimpleJSON is an unordered map of various types(boolean, String, integers, null) and other SimpleJSON documents
 *  {
 *      z: true,
 *      f: null,
 *      a: {
 *          a:"world"
 *      }
 *  }
 *
 *  Common Issues:
 *  Diff tool
 *  A Common issue is that TC will want to leverage a tool such as diff. The challenge lies in the maps are unordered
 *  and therefore
 *  the output would be inconsistent.
 *  The following two SimpleJSON records would produce a diff result but are identical according to the SimpleJSON
 *  specifications.
 *  {
 *      z: true,
 *      f: null,
 *  }
 *
 *  {
 *      f: null,
 *      z: true
 *  }
 *
 *  Minimal deltas
 *
 *  A Common issue is that the TC may identify to send some form of delta models over the wire but fail to identify
 *  the goal to send
 *  smallest delta.
 *  If a change occurs deep within a nested SimpleJSON object, the goal should be to transmit the smallest
 *  information necessary.
 *
 * Equality Check
 * At some point in the solution there will be an equality check against the value of two keys with same value.
 * Care should be taken only perform the check for premitive(Integer, String, Boolean) types and not other nested
 * SimpleJSON documents otherwise the runtime of the algorithm may become exponential rather than linear on the
 * number of keys.
 * Follow Up Question #1 How can we handle arrays?
 * How can arrays if added the SimpleJSON specification be handled ?
 * The chanllenges that Arrays may introduce are that with the limited operand set(CURD), the number of operations for
 * a change to an array could cause a larger payload to be transmitted than original document.
 *
 * #Document 1
 * {"array": {0, 1, 2, 3}}
 *
 * #Document 2
 * {"array": {0, 1, 1, 2, 3 }}
 *
 *
 *
 */


public class JsonWebpageSaver {

    public static void main(String[] args) {
        System.out.println("Hello Google");
    }
}
