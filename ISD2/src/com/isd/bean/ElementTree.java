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
	 * ��ӻ�Ԫ�ڵ�
	 * 
	 * @param en
	 */
	public void addElementNode(ElementNode en) {
		// �����ӽڵ�ĸ��ڵ��Ƿ�Ϊ�գ����������ڵ�
		if ("null".equals(en.getInfo().getPrecursorName())) {
			root.put(en.getInfo().getName(), en);
		} else { // ��Ϊ�գ�����������㼰�ӽڵ㣬��������ڶ�Ӧ�ĸ��ڵ���
			// �������ڵ�
			for (Entry<String, ElementNode> enn : root.entrySet()) {
				// ������ڵ����������ӵĽڵ㸸�ڵ��������ͬ,������ӵ���Ӧ�ĸ��ڵ���
				if (enn.getKey().equals(en.getInfo().getPrecursorName().trim())) {
					enn.getValue().addChild(en);
					break;
				} else {// �Ӹ��ڵ�Ϊʼ�ڵ㿪ʼ��������ӽڵ�
					addElementNode(enn.getValue(), en);
				}
			}
		}
	}

	/**
	 * �Ե�ǰ�ڵ�Ϊ���ڵ㣬����ӽڵ�����Ӧ�Ľڵ�
	 * 
	 * @param currentNode
	 * @param en
	 */
	private void addElementNode(ElementNode currentNode, ElementNode en) {
		// �����ӽڵ�ĸ��ڵ����ֵ��ڵ�ǰ�ڵ�����֣�������뵱ǰ�ڵ�
		if (en.getInfo().getPrecursorName()
				.equals(currentNode.getInfo().getName())) {
			currentNode.addChild(en);
			return;
		} else {
			// ������ǰ�ڵ���ӽڵ�
			for (Entry<String, ElementNode> enn : currentNode.getChildNodes()
					.entrySet()) {
				addElementNode(enn.getValue(), en);
			}
		}
	}

	/**
	 * ��������ɾ��ĳ����Ԫ
	 * 
	 * @param name
	 *            Ҫɾ����Ԫ������
	 * @param deleteChilds
	 *            �Ƿ�ɾ���˽ڵ��µ������ӽڵ�
	 */
	public boolean deleteElementNode(String name, boolean deleteChilds) {
		return deleteElementNode(root, name, deleteChilds);
	}

	/**
	 * ��������ɾ�����ڵ��µ�ĳ����Ԫ
	 * 
	 * @param root
	 *            ���ڵ�
	 * @param name
	 *            Ҫɾ����Ԫ������
	 * @param deleteChilds
	 *            �Ƿ�ɾ���˽ڵ��µ������ӽڵ�
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
	 * �������е��ӽڵ�
	 * 
	 * @return
	 */
	public ArrayList<ElementNode> getAllChildNode() {
		ArrayList<ElementNode> childs = null;
		if (root.size() != 0) {
			childs = new ArrayList<ElementNode>();
			for (Entry<String, ElementNode> enn : root.entrySet()) {
				// ������ڵ����������ӵĽڵ㸸�ڵ��������ͬ,������ӵ���Ӧ�ĸ��ڵ���
				getChildNode(childs, enn.getValue());
			}
		}
		return childs;
	}

	/**
	 * �Բ�εķ�ʽ�������нڵ�
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
			// ��ӱ���ڵ�
			Collection<ElementBean> currentNode = new ArrayList<ElementBean>();
			for (ElementNode eb : roots) {
				currentNode.add(eb.getInfo());
			}
			childs.add(currentNode);
			// ��������ڵ㲢�ռ����б��ڵ���ӽڵ�
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
	 * �������Ϊ�գ��򷵻����и��ڵ������
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
	 * �������Ϊ�գ��򷵻����и��ڵ�������Լ���Ӧ��ID
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
