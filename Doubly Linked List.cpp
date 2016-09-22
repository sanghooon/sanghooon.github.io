//doubly linked list
#include <iostream>
#include "stdio.h"
using namespace std;

class node {
	public:
		node *next;
		node *prev;
		int data; 
		node(int value);
		~node();
};
node::node(int value) {
	this->data = value;
	this->next = NULL;
	this->prev = NULL;
}
node::~node() {
	if(this->next != NULL) delete this->next;
	cout << this->data << " deleted" << endl;
}
class list {
	public:
		node *head;
		node *tail;
		list();
		~list();
		void append(node *newNode);
		void Print();
		void swap(node *a, node *b);
		bool sortSwap();
};
list::list() {
	this->head = NULL;
	this->tail = NULL;
}
list::~list() {
	if(this->head != NULL)
		delete head;
}
void list::append(node *newNode) {
	if(this->head == NULL) {
		this->head = newNode;
		this->tail = newNode;
	}
	else {
		this->tail->next = newNode;
		newNode->prev = tail;
	}
	tail = newNode;
}
void list::Print() {
	for(node *i = head; i != NULL; i = i->next)
            printf("%d ", i->data);
        printf("\n");
}
void list::swap(node *a, node *b) {
	int temp = a->data;
	a->data = b->data;
	b->data = temp;
}
bool list::sortSwap() {
	bool needsort = false;     
        node* prev = head;
        for(node* i = this->head; i != NULL && i->next != NULL ; i = i->next)
            if( i->data < i->next->data) {
                this->swap(i, i->next);
                needsort = true;
                prev = i->next;
            }
		return needsort;
}
int main() {
	list *l = new list();
	for(int i = 0; i < 10; i++) {
		l->append(new node(i));
	}
	l->Print();
	for(bool doswap = true; doswap; doswap = l->sortSwap());
	l->Print();
	
	delete l;

	return 0;
}
