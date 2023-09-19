package com.animal.guessing;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;

public class DecisionTree {

    private Node root;
    private IBehaviour behaviour;

    public DecisionTree() {}

    public DecisionTree(IBehaviour behaviour) {
        this.behaviour = behaviour;
    }

    public boolean execute() {
        if(this.root == null) {
            this.root = behaviour.emptyTree();
            return true;
        } else {
            return this.execute(this.root);
        }
    }

    private boolean execute(Node n) {
        if(n.isLeaf()) {
            return behaviour.processLeafNode(n);
        } else {
            if(behaviour.processNonLeafNode(n)) {
                return execute(n.getRight());
            } else {
                return execute(n.getLeft());
            }
        }
    }

    public String display() {
        StringBuilder sb = new StringBuilder();
        display(sb, 0, "root:", root);
        return sb.toString();
    }

    private void display(StringBuilder sb, int level, String direction, Node node) {
        if(node == null) {
            return;
        }

        level = level + 2;
        for(int i=0;i<level;i++) {
            sb.append("  ");
        }
        sb.append(String.format("%s %s %d\n", direction, node.getData(), node.getLabel()));
        display(sb, level, "left: ", node.getLeft());
        display(sb, level, "right: ", node.getRight());
    }

    private void buildTreeMap(Node node, Map<String, Object> branch, String key) {
        if(node != null) {
            if(node.isLeaf()) {
                branch.put(key, node.getData());
            } else {
                Map<String, Object> branch2 = new HashMap<>();
                buildTreeMap(node.getLeft(), branch2, "left_" + node.getData());
                buildTreeMap(node.getRight(), branch2, "right_" + node.getData());

                String prefix = key.startsWith("root") ? "root" : key.startsWith("left") ? "left" : "right";

                branch.put( prefix + "_" + node.getData(), branch2);
            }
        }
    }

    private int label(Node n, int count) {
        return count;
    }

    public void save(String name) throws Exception {
        Map<String, Object> treeMap = new HashMap<>();
        buildTreeMap(root, treeMap, "root");
        ObjectMapper objectMapper = new ObjectMapper();
        String decisionTreeJsonString = objectMapper.writeValueAsString(treeMap);

        Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(name)));
        writer.write(decisionTreeJsonString);
        writer.close();
    }

    private void save(Node node, Formatter formatter) {

    }

    public void load(String fname) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fname)));
        StringBuilder sb = new StringBuilder();
        String line;
        while((line = reader.readLine()) != null) {
            sb.append(line);
        }
        String decisionJsonString = sb.toString();
        Map<String, Object> decisonMap = new ObjectMapper().readValue(decisionJsonString, new TypeReference<>() {} );

        for(String k : decisonMap.keySet()) {

            if(k == "root") {
                root = new Node(decisonMap.get(k).toString());
                break;
            }

            root = new Node(k.split("_")[1]);

            try {
                buildDecisionTreeFromMap(root, (Map<String, Object>) decisonMap.get(k));
            } catch(ClassCastException classCastException) {
                // Only one leaf
            }
            break;
        }
    }

    private void buildDecisionTreeFromMap(Node node, Map<String, Object> decisonMap) {
        if(decisonMap.keySet().size() < 1) {
            return;
        }

        for(String k : decisonMap.keySet()) {
            try {
                // Successful cast implies a Non Leaf Node
                Map<String, Object> subBranch = (Map<String, Object>) decisonMap.get(k);
                String[] tokens = k.split("_");
                Node nonLeafNode = new Node(tokens[1]);
                if(tokens[0].equals("left")) {
                    node.left = nonLeafNode;
                } else if (tokens[0].equals("right")){
                    node.right = nonLeafNode;
                }
                buildDecisionTreeFromMap(nonLeafNode, subBranch);

            } catch (ClassCastException classCastException) {
                // Implies a leaf
                String[] tokens = k.split("_");
                Node leafNode = new Node(decisonMap.get(k).toString());
                if(tokens[0].equals("left")) {
                    node.left = leafNode;
                } else if (tokens[0].equals("right")){
                    node.right = leafNode;
                }
            }
        }
    }

    private Node insert(Node n, Node t) {
        return null;
    }
}
