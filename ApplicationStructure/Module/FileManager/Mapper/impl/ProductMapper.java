package ApplicationStructure.Module.FileManager.Mapper.impl;

import ApplicationStructure.Module.FileManager.Mapper.Mapper;
import ApplicationStructure.Module.StorageStructure.Element.PlayableToy;


public class ProductMapper implements Mapper<PlayableToy> {
    @Override
    public String toInput(PlayableToy toy) {
        return String.format("%s,%s", toy.getName(), toy.getAmount());
    }

    @Override
        public PlayableToy toOutput(String s) {
            String[] lines = s.split(",");
            int amount;
            if (isDigit(lines[1])) {
                amount = Integer.parseInt(lines[1]);
                return new PlayableToy(lines[0], amount);
            }
            throw new NumberFormatException("Id must be a large number");
        }

        private boolean isDigit(String s) throws NumberFormatException {
            try {
                Integer.parseInt(s);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }
    }

