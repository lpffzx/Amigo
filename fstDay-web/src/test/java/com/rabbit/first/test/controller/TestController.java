package com.rabbit.first.test.controller;

public class TestController {


//    @Test(expectedExceptions = OptimisticLockException.class)
//    public void firstCommitWins() throws Throwable {
//        UserTransaction tx = TM.getUserTransaction();
//        try {
//            tx.begin();
//            EntityManager em = JPA.createEntityManager();
//            TestItemDO someItem = new TestItemDO();
//            someItem.setName("fst_item");
//            em.persist(someItem);
//            tx.commit();
//            em.close();
//            final Integer ITEM_ID = someItem.getId();
//
//            tx.begin();
//            em = JPA.createEntityManager();
//            TestItemDO item = em.find(TestItemDO.class, ITEM_ID);
//            assertEquals(item.getVersion(), 0);
//            item.setName("sec_item");
//            Executors.newSingleThreadExecutor().submit(new Callable<Object>() {
//                @Override
//                public Object call() throws Exception {
//                    UserTransaction tx = TM.getUserTransaction();
//                    try {
//                        tx.begin();
//                        EntityManager em = JPA.createEntityManager();
//                        TestItemDO item = em.find(TestItemDO.class, ITEM_ID);
//
//                        assertEquals(item.getVersion(), 0);
//                        item.setName("thd_item");
//                        tx.commit();
//                        em.close();
//                    } catch (Exception e) {
//                        TM.rollback();
//                        throw new RuntimeException("Concurrent operation failure: " + e, e);
//                    }
//
//                    return null;
//                }
//            }).get();
//
//            em.flush();
//
//        } catch (Exception e) {
//            throw unwrapCauseOfType(e, OptimisticLockException.class);
//        } finally {
//            TM.rollback();
//        }
//
//    }
}
