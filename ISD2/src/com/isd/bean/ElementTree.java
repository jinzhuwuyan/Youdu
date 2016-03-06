package com.isd.bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;

public class ElementTree {
	private HashMap<String, ElementNode> root = null;

	public ElementTree() {
		root = new HashMap<String, ElementNode>();
	}

	public HashMap<String, ElementNode> getEtm() {
		return root;
	}

	/**
	 * 添加基元节点
	 * 
	 * @param en
	 */
	public void addElementNode(ElementNode en) {
		// 如果添加节点的父节点是否为空，则将其加入根节点
		if ("null".equals(en.getInfo().getPrecursorName())) {
			root.put(en.getInfo().getName(), en);
		} else { // 不为空，则遍历根基点及子节点，将其添加在对应的父节点下
			// 遍历父节点
			for (Entry<String, ElementNode> enn : root.entrySet()) {
				// 如果根节点的名字与添加的节点父节点的名字相同,则将其添加到相应的根节点下
				if (enn.getKey().equals(en.getInfo().getPrecursorName().trim())) {
					enn.getValue().addChild(en);
					break;
				} else {// 从父节点为始节点开始迭代添加子节点
					addElementNode(enn.getValue(), en);
				}
			}
		}
	}

	/**
	 * 以当前节点为根节点，添加子节点至相应的节点
	 * 
	 * @param currentNode
	 * @param en
	 */
	private void addElementNode(ElementNode currentNode, ElementNode en) {
		// 如果添加节点的父节点名字等于当前节点的名字，则将其加入当前节点
		if (en.getInfo().getPrecursorName()
				.equals(currentNode.getInfo().getName())) {
			currentNode.addChild(en);
			return;
		} else {
			// 遍历当前节点的子节点
			for (Entry<String, ElementNode> enn : currentNode.getChildNodes()
					.entrySet()) {
				addElementNode(enn.getValue(), en);
			}
		}
	}

	/**
	 * 根据名字删除某个基元
	 * 
	 * @param name
	 *            要删除基元的名字
	 * @param deleteChilds
	 *            是否删除此节点下的所有子节点
	 */
	public boolean deleteElementNode(String name, boolean deleteChilds) {
		return deleteElementNode(root, name, deleteChilds);
	}

	/**
	 * 根据名字删除父节点下的某个基元
	 * 
	 * @param root
	 *            父节点
	 * @param name
	 *            要删除基元的名字
	 * @param deleteChilds
	 *            是否删除此节点下的所有子节点
	 * @return
	 */
	public boolean deleteElementNode(HashMap<String, ElementNode> root,
			String name, boolean deleteChilds) {
		if (root.containsKey(name)) {
			if (root.get(name).containsChild() && deleteChilds) {
				root.remove(name);
				return true;
			} else if (!root.get(name).containsChild()) {
				root.remove(name);
				return true;
			}
		} else {
			for (Entry<String, ElementNode> enn : root.entrySet()) {
				if (deleteElementNode(enn.getValue().getChildNodes(), name,
						deleteChilds)) {
					return true;
				}
			}
		}
		return false;
	}

	public void updateElementNode(ElementNode en) {

	}

	/**
	 * 返回所有的子节点
	 * 
	 * @return
	 */
	public ArrayList<ElementNode> getAllChildNode() {
		ArrayList<ElementNode> childs = null;
		if (root.size() != 0) {
			childs = new ArrayList<ElementNode>();
			for (Entry<String, ElementNode> enn : root.entrySet()) {
				// 如果根节点的名字与添加的节点父节点的名字相同,则将其添加到相应的根节点下
				getChildNode(childs, enn.getValue());
			}
		}
		return childs;
	}

	/**
	 * 以层次的方式返回所有节点
	 * 
	 * @return
	 */
	public ArrayList<Collection<ElementBean>> getAllChildNodeByLevel() {
		ArrayList<Collection<ElementBean>> childs = new ArrayList<Collection<ElementBean>>();
		addChildBylevel(childs, root.values());
		return childs;
	}

	private void addChildBylevel(ArrayList<Collection<ElementBean>> childs,
			Collection<ElementNode> roots) {
		if (roots.size() != 0) {
			// 添加本层节点
			Collection<ElementBean> currentNode = new ArrayList<ElementBean>();
			for (ElementNode eb : roots) {
				currentNode.add(eb.getInfo());
			}
			childs.add(currentNode);
			// 遍历本层节点并收集所有本节点的子节点
			Collection<ElementNode> child = new ArrayList<ElementNode>();
			for (ElementNode enn : roots) {
				//
				if (enn.getChildNodes() == null) {
					continue;
				}
				child.addAll(enn.getChildNodes().values());
			}
			if (childs.size() == 0) {
				return;
			} else {
				addChildBylevel(childs, child);
			}
		}
	}

	private void getChildNode(ArrayList<ElementNode> results,
			ElementNode parentNode) {
		results.add(parentNode);
		for (Entry<String, ElementNode> enn : parentNode.getChildNodes()
				.entrySet()) {
			getChildNode(results, enn.getValue());
		}
	}

	/**
	 * 如果参数为空，则返回所有父节点的名字
	 * 
	 * @param childNodeName
	 * @return
	 */
	public ArrayList<String> getParentNodeName() {
		ArrayList<String> names = new ArrayList<String>();
		if (null != getAllChildNode()) {
			for (ElementNode en : getAllChildNode()) {
				names.add(en.getInfo().getName());
			}
		} else {
			names.add("null");
		}
		return names;
	}

	/**
	 * 如果参数为空，则返回所有父节点的名字以及对应的ID
	 * 
	 * @param childNodeName
	 * @return
	 */
	public HashMap<String, String> getNodeNameAndId() {
		HashMap<String, String> names = new HashMap<String, String>();
		if (null != getAllChildNode()) {
			for (ElementNode en : getAllChildNode()) {
				names.put(en.getInfo().getName(), en.getInfo().getUuid());
			}
		} else {
			names.put("null", "-1");
		}
		return names;
	}
}
