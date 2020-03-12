JAVAC=/usr/bin/javac
.SUFFIXES: .java .class

SRCDIR=src
BINDIR=bin

$(BINDIR)/%.class:$(SRCDIR)/%.java
	$(JAVAC) -d $(BINDIR)/ -cp $(BINDIR) $<

CLASSES= BST.class AVL.class LoadShedApp.class\
	 BTQueueNode.class BTQueue.class \
	 BinaryTreeNode.class BinaryTree.class \
	 BinarySearchTree.class BinarySearchTreeTest.class
	 

default: $(CLASS_FILES)

clean:
	rm $(BINDIR)/*.class
run:
	@java -cp bin LoadShedApp.class