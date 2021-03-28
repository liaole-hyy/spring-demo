package com.example.demo;

import org.mockito.*;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.List;

public class MockTest {

    public static void main(String[] args) {
        // 创建mock对象
        List mockedList = Mockito.mock(List.class);

//        mockedList.add("1111");
//        mockedList.clear();
//
//        Mockito.verify(mockedList).add("22221111");
//        Mockito.verify(mockedList).clear();

        Mockito.when(mockedList.get(0)).thenReturn("first");
        Mockito.when(mockedList.get(1)).thenThrow(new RuntimeException());

        //System.out.println(mockedList.get(0));

        //System.out.println(mockedList.get(1));

//        System.out.println(mockedList.get(9999)); //返回null
//        Mockito.verify(mockedList).get(0);//验证调用
        Mockito.when(mockedList.get(Mockito.anyInt())).thenReturn("element");
        // 使用自定义的参数匹配器( 在isValid()函数中返回你自己的匹配器实现 )
        //Mockito.when(mockedList.contains(Mockito.argThat(isValid()))).thenReturn("element");
        //System.out.println(mockedList.get(100));
        //校验次数
        //Mockito.verify(mockedList,Mockito.times(3));
        //测试顺序
        InOrder inOrder =Mockito.inOrder(mockedList);
//        inOrder.verify(mockedList).add("1");
//        inOrder.verify(mockedList).add("2");


//        MockitoAnnotations.initMocks(testClass); 可以初始化被@Mock标记的对象
        //Mockito.doThrow(new RuntimeException()).when(mockedList).clear();
        Mockito.when(mockedList.get(0)).thenAnswer(new Answer<Object>() {

            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                Object[] args = invocation.getArguments();
                Object mock = invocation.getMock();
                return "called with arguments: " + args;
            }
        });

        System.out.println(mockedList.get(0));
    }

}
