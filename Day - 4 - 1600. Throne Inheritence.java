import java.util.*;

class ThroneInheritance {
    private final String king;
    private final Map<String, List<String>> children;
    private final Set<String> dead;

    public ThroneInheritance(String kingName) {
        king = kingName;
        children = new HashMap<>();
        dead = new HashSet<>();
    }
    
    public void birth(String parentName, String childName) {
        children.computeIfAbsent(parentName, k -> new ArrayList<>()).add(childName);
    }
    
    public void death(String name) {
        dead.add(name);
    }
    
    public List<String> getInheritanceOrder() {
        List<String> order = new ArrayList<>();
        dfs(king, order);
        return order;
    }
    
    private void dfs(String name, List<String> order) {
        if (!dead.contains(name)) {
            order.add(name);
        }
        List<String> kids = children.get(name);
        if (kids != null) {
            for (String child : kids) {
                dfs(child, order);
            }
        }
    }
}
